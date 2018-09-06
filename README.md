Micro Apps
==========
Modern microservices for Post-Kubernetes Era.
Monorepo(apps, libs) project to showcase workspace setup with multiple apps and shared libraries

### Features
1. **Polyglot** - Support multiple languages (java, kotlin, groovy)
2. Support multiple app frameworks (spring-boot, cli, micronaut)
3. Support multiple testing frameworks (Spock, Spek, kotlin-test and JUnit5) 
4. Build **lightweight** Docker and [OCI](https://github.com/opencontainers/image-spec) images with [Jib](https://github.com/GoogleContainerTools/jib)
5. Build native binaries using [GraalVM](https://www.graalvm.org/)
6. Cloud Native (Service Mesh, health checks, observability)


### Run

#### Docker
> start app dependencies: mongodb, kafka 
```bash
# start local mongodb
docker-compose up -V mongodb
# stop local mongodb before restart again
docker-compose down -v
# start local kafka
docker-compose up broker
```

#### Spring Boot
> Start all 3 apps: [guestbook-api](./apps/guestbook-api/), [stream-api](./apps/stream-api/), [guestbook-app](./apps/guestbook-app/) 

#### Micronaut
> Start [Greeting API](./apps/greeting-api/)

> Start [Hello World Native API](./apps/hello-world-native/)


### Inspiration 
* Creating a [Multi Module Project](https://spring.io/guides/gs/multi-module/)
* Microservices in a Post-Kubernetes Era [link](https://www.infoq.com/articles/microservices-post-kubernetes)
* Why is a [workspace](https://nrwl.io/nx/why-a-workspace) (or monorepo) needed? 
