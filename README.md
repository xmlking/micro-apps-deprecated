Micro Apps
==========

Monorepo(apps, libs) project to showcase workspace setup with multiple apps and shared libraries

### Features
1. **Polyglot** - Support multiple languages (java, kotlin, groovy)
1. Support multiple app frameworks (spring-boot, cli, micronaut)
2. Support multiple testing frameworks (Spock, Spek and JUnit5) 
3. Build Docker and [OCI](https://github.com/opencontainers/image-spec) images with [Jib](https://github.com/GoogleContainerTools/jib) 
4. Cloud Native (discovery, health checks, observability)


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

### Gradle Commands
```bash
# upgrade project gradle version
gradle wrapper --gradle-version 4.10 --distribution-type all
# gradle daemon status 
gradle --status
gradle --stop
# show dependencies
gradle classifier:dependencies
gradle classifier:dependencyInsight --dependency spring-messaging
# refresh dependencies
gradle build -x test --refresh-dependencies 
```


### Inspiration 
* Creating a [Multi Module Project](https://spring.io/guides/gs/multi-module/)
* Microservices in a Post-Kubernetes Era [link](https://www.infoq.com/articles/microservices-post-kubernetes)
* Why is a [workspace](https://nrwl.io/nx/why-a-workspace) (or monorepo) needed? 
