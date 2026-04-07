def call(Map config = [:]) {
    sh "IMAGE_TAG=${config.tag} DOCKER_REPO=${config.repo} docker compose down && docker compose up -d"
}
