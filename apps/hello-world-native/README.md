Hello World Native
==================

**Micronaut** Demo Service to showcase **Graal** native image builds.

### Prerequisites
> see [PLAYBOOK](../../PLAYBOOK.md)

#### Install Graal
```bash
sdk install java 1.0.0-rc6-graal
sdk use java 1.0.0-rc6-graal
```

#### Publish SVM to Local Maven Cache
```bash
# make sure you added  `mavenLocal()` to gradle file.
mvn install:install-file -Dfile=${JAVA_HOME}/jre/lib/svm/builder/svm.jar -DgroupId=com.oracle.substratevm -DartifactId=svm -Dversion=GraalVM-1.0.0-rc6 -Dpackaging=jar
```

### Quickstart

#### Build
```bash
gradle :apps:hello-world-native:clean
gradle :apps:hello-world-native:build
# skip test
gradle :apps:hello-world-native:build -x test 
# docker build
gradle :apps:hello-world-native:jibDockerBuild
# native build
gradle :apps:hello-world-native:build -x test
gradle :apps:hello-world-native:run
# This will generate a build/reflect.json file after performing classloading analysis.
cd apps/hello-world-native
./build-native-image.sh
```

#### Run
```bash
gradle :apps:hello-world-native:run
# with docket
docker run -d -p 8080:8080 xmlking/micro-apps-hello-world-native:1.0.0-SNAPSHOT
# run native build
cd apps/hello-world-native
./build/hello-world-native
```

#### Test
```bash
curl http://localhost:8080/hello/World
> Hello World

gradle :apps:hello-world-native:test
```



### Credit
* Micronaut Java Graal Native Image [link](https://github.com/graemerocher/micronaut-graal-experiments/tree/master/hello-world-java)
