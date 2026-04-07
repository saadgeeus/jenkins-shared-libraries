def call(String repo, String tag) {
    sh "docker rmi ${repo}:${tag} || true"
    sh "docker image prune -f"
}
