Guestbook API
=============

**Spring Book** Demo Service to showcase *JUnit5* and *Jib* builds

## Quickstart

### Build
```bash
gradle :apps:guestbook-api:build
# skip test
gradle :apps:guestbook-api:build -x test 
# docker build
gradle :apps:guestbook-api:jibDockerBuild
```

### Run
```bash
gradle :apps:guestbook-api:bootRun
# run with `dev` profile.
SPRING_PROFILES_ACTIVE=dev gradle :apps:guestbook-api:bootRun
# with docket
docker run -d -p 8081:8081 xmlking/micro-apps-guestbook-api:1.0.0-SNAPSHOT
```

### Test
```bash
curl -X POST \
  http://localhost:8081/messages \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
"id": "aaa",
"payload": "aaa bbb",
"delay": 1
}'

gradle :apps:guestbook-api:test
```
