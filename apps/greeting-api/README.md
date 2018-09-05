Greeting API
============

**Micronaut** Demo Service to showcase *Spek2* and *Jib* builds

## Quickstart

### Build
```bash
gradle :apps:greeting-api:build
# skip test
gradle :apps:greeting-api:build -x test 
# docker build
gradle :apps:greeting-api:jibDockerBuild
# native build
gradle :apps:greeting-api:assemble
# This will generate a build/reflect.json file after performing classloading analysis.
java -jar build/libs/greeting-api-1.0.0-SNAPSHOT-all.jar

```

### Run
```bash
gradle :apps:greeting-api:run
# with docket
docker run -d -p 8080:8080 xmlking/micro-apps-greeting-api:1.0.0-SNAPSHOT
```

### Test
```bash
curl localhost:8080/greeting
> Hello World

gradle :apps:greeting-api:test
```


### With Kubernetes

```bash
IMAGE=<your image, eg. gcr.io/micro-apps/greeting-api>

gradle :apps:greeting-api:jib --image=$IMAGE

kubectl run micronaut-jib --image=$IMAGE --port=8080 --restart=Never

# Wait until pod is running
kubectl port-forward greeting-api 8080 > /dev/null 2>&1 &
```
```bash
curl localhost:8080/hello
> Hello World
```


## Credit
* Containerize a [Micronaut with Jib](https://github.com/GoogleContainerTools/jib/tree/master/examples/micronaut)
* @TimRiemer [Micronaut with Spek2](https://github.com/TimRiemer/micronaut_kotlin_spek)
* Micronaut Java Graal Native Image [link](https://github.com/graemerocher/micronaut-graal-experiments/tree/master/hello-world-java)
