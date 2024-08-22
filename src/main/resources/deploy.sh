oc new-build --binary --name=springboot-app openshift/ubi8-openjdk-17:1.12
mvn -T 1C clean package -DskipTests
oc start-build springboot-app --from-file=target/kafka-consumer-0.0.1-SNAPSHOT.jar --follow
oc create configmap springboot-app --from-literal=SPRING_BOOT_PROFILE=dev
oc new-app springboot-app
oc set env --from=configmap/springboot-app deploy/springboot-app
oc expose service/springboot-app

curl --location --request POST 'http://{URL_APP}/send?topic=sanderson&message=hello%20world'


