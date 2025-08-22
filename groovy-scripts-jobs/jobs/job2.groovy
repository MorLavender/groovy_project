// job1.groovy
node {
    stage('Preparation') {
        echo "Starting demo pipeline..."
        echo "Running on: ${env.JENKINS_URL}"
        echo "Workspace: ${env.WORKSPACE}"

        // Example: Clean workspace before checkout
        deleteDir()
    }

    stage('Checkout') {
        echo "Checking out repository..."
        // Replace with your own repo URL
        git branch: 'main', url: 'https://github.com/example/repo.git'
    }

    stage('Build') {
        echo "Building the project..."
        // Dummy build command - replace with your build tool
        sh 'echo "Compiling source..."'
        sh 'mkdir -p build && echo "Hello Jenkins!" > build/output.txt'
    }

    stage('Test') {
        echo "Running tests..."
        // Example dummy test step
        sh 'echo "Tests passed!"'
    }

    stage('Archive') {
        echo "Archiving build artifacts..."
        archiveArtifacts artifacts: 'build/**', fingerprint: true
    }

    stage('Complete') {
        echo "Pipeline complete!"
    }
}
