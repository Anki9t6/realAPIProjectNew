pipeline {
    agent any

    parameters {
        choice(name: 'VERSION', choices: ['v2', 'v3'], description: 'Select Code Version')
    }

    stages {

        stage('Checkout Code from Git') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'main']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/Anki9t6/realAPIProjectNew.git',
                        credentialsId: 'git-credentials'
                    ]]
                ])
            }
        }

        stage('Show Selected Version') {
            steps {
                echo "Selected Version: ${params.VERSION}"
            }
        }

        stage('Run Build / Tests') {
            steps {
                echo "Running code for VERSION: ${params.VERSION}"
                sh "mvn clean test -Dversion=${params.VERSION}"
            }
        }

        // ✅ NEW: Store report separately per build
        stage('Store Report Per Build') {
    steps {
        sh """
        mkdir -p Reports/${BUILD_NUMBER}
        cp reports/ExtentReport.html Reports/${BUILD_NUMBER}/
        """
    }
}
    }

    post {
        always {

            // ✅ Publish HTML in Jenkins UI
            publishHTML(target: [
                reportDir: 'reports',
                reportFiles: 'ExtentReport.html',
                reportName: "Extent Report - Build ${BUILD_NUMBER}",
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])

            // ✅ Archive reports (download option)
            archiveArtifacts artifacts: 'Reports/**', fingerprint: true
              // ✅ Email Notification
            emailext(
                subject: "Build ${BUILD_NUMBER} - ${currentBuild.currentResult}",
                body: """
                    <h2>Jenkins Build Notification</h2>

                    <p><b>Project:</b> ${env.JOB_NAME}</p>
                    <p><b>Build Number:</b> ${BUILD_NUMBER}</p>
                    <p><b>Status:</b> ${currentBuild.currentResult}</p>
                    <p><b>Version Tested:</b> ${params.VERSION}</p>

                    <p>
                        <a href="${env.BUILD_URL}HTML_20Report/">👉 View HTML Report</a>
                    </p>

                    <p>
                        <a href="${env.BUILD_URL}">👉 View Build Details</a>
                    </p>
                """,
                to: 'ankitwebsites5@gmail.com',
                mimeType: 'text/html'
            )
        }
    }
}