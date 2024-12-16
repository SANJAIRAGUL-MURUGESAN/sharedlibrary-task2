def call(Map config = [:]) {
    // Export AWS credentials as environment variables
    withEnv([
        "AWS_ACCESS_KEY_ID=${config.awsAccessKeyId}",
        "AWS_SECRET_ACCESS_KEY=${config.awsSecretAccessKey}",
        "AWS_SESSION_TOKEN=${config.awsSessionToken}"
    ]) {
        // Execute the login command using the provided AWS credentials
        sh "aws ecr get-login-password --region ${config.region} | docker login --username AWS --password-stdin ${config.repo_uri}"
    }
}