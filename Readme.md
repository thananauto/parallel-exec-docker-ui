# parallel-exec-docker-ui
This projects demonstrates how to setup the selenium grid different ways with help of docker


# Installation
clone this project, this consist of sample UI script with `TestNG` as runner

### Contents
1. Standalone browsers images - [`docker-compose-standalone-chrome.yml`](docker-compose-standalone-chrome.yml) [![Standalone chrome](https://github.com/thananauto/testng-selenoid-ui/actions/workflows/test_stanalone_chrome.yml/badge.svg)](https://github.com/thananauto/testng-selenoid-ui/actions/workflows/test_stanalone_chrome.yml)
2. Hub and Node setup using docker-compose - [`docker-compose-v3-grid.yml`](docker-compose-v3-grid.yml)[![Selenium Grid - Hub and Nodes](https://github.com/thananauto/testng-selenoid-ui/actions/workflows/test_hub_node.yml/badge.svg)](https://github.com/thananauto/testng-selenoid-ui/actions/workflows/test_hub_node.yml)
3. Selenoid  [`docker-compose.yml`](docker-compose.yml) and [`docker-compose-tests.yml`](docker-compose-tests.yml) [![Selenoid + script on container](https://github.com/thananauto/testng-selenoid-ui/actions/workflows/test_selenoid_Dockerfile.yml/badge.svg)](https://github.com/thananauto/testng-selenoid-ui/actions/workflows/test_selenoid_Dockerfile.yml) and [![Selenoid + Script on host](https://github.com/thananauto/testng-selenoid-ui/actions/workflows/test_selenoid.yml/badge.svg)](https://github.com/thananauto/testng-selenoid-ui/actions/workflows/test_selenoid.yml)
4. Zalenium [docker-compose-zalenium.yml](docker-compose-zalenium.yml) [![Zalenium](https://github.com/thananauto/parallel-exec-docker-ui/actions/workflows/test_zalenium.yml/badge.svg)](https://github.com/thananauto/parallel-exec-docker-ui/actions/workflows/test_zalenium.yml)


For workflow execution logs and details refer `Actions` tab of repo

## Reference
1. [Selenium Grid Docker](https://github.com/SeleniumHQ/docker-selenium/blob/trunk/README.md)
2. [Selenium-hub](https://hub.docker.com/u/selenium)
3. [Selenoid](https://aerokube.com/selenoid/latest/)
