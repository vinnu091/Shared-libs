def call(String credId,String imgName){
    withCredentials([usernamePassword(credentialsId:${credId},passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")]){
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                    sh "docker tag ${imgName} ${env.dockerHubUser}/${imgName}:latest"
                    sh "docker push ${env.dockerHubUser}/${imgName}:latest"
}