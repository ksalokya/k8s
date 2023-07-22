# k8s

## Minikube - [Website](https://minikube.sigs.k8s.io/docs/start/)

```js
New-Item -Path 'c:\' -Name 'minikube' -ItemType Directory -Force
Invoke-WebRequest -OutFile 'c:\minikube\minikube.exe' -Uri 'https://github.com/kubernetes/minikube/releases/latest/download/minikube-windows-amd64.exe' -UseBasicParsing
```

```js 
$oldPath = [Environment]::GetEnvironmentVariable('Path', [EnvironmentVariableTarget]::Machine)
if ($oldPath.Split(';') -inotcontains 'C:\minikube'){
  [Environment]::SetEnvironmentVariable('Path', $('{0};C:\minikube' -f $oldPath), [EnvironmentVariableTarget]::Machine)
}
```

```js
minikube start
```

#### Run below command to start minikube with Docker
```js
minikube start --driver=docker
```
#### Verify minikube status
```js
minikube status
```
#### Verify cluster info and node status
```js
kubectl cluster-info
```

#### To allow Kubernetes to read your docker repository you need to run below command
```js
minikube docker-env
```
###### Note :: REM To point your shell to minikube's docker-daemon, run command using powershell :
```js 
& minikube -p minikube docker-env --shell powershell | Invoke-Expression
```
### Build Spring Boot Application
```js
docker build -t boot-k8s:latest .
```

### Describe deployment object details and apply it
```js
kubectl apply -f k8s\deployment.yaml
```

#### Verify deployment
```js
kubectl get deployments
```
#### Verify pods
```js
kubectl get pods
```
#### List events
```js
kubectl get events
```
#### Delete deployment
```js
kubectl delete deployment <name>
```
#### Get logs of POD -> Verify your application is running properly
```js
kubectl logs <pod name>
```
### Describe service object details and apply it
```js
kubectl apply -f service.yaml
```
#### Verify Service 
```js
kubectl get service
```
#### Verify Node IP
```js
kubectl get nodes -o wide
```
###### Note : Use Port and IP obtained from `Verify Service` and `Verify Node IP` command

#### Get Proxy URL
```js
minikube service <service name> --url
```

#### Access Dashboard
```js
minikube dashboard
```

### On Windows, you can set up the Resource Metrics Server (metrics-server) in your Kubernetes cluster using the following steps:

#### Download Metrics Server YAML File
```js
curl -LO https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
```
#### Edit Metrics Server YAML
```js
- name: metrics-server
  ...
  args:
    - --cert-dir=/tmp
    - --secure-port=4443
    - --kubelet-insecure-tls   # Add this line
```

#### Apply Metrics Server YAML
```js
kubectl apply -f components.yaml
```

#### Verify Metrics logs
```js
http://127.0.0.1:<dashboard port>/metrics
```

#### Stop minikube
```js 
minikube stop
```

#### Delete a local Kubernetes cluster
```js 
minikube delete
```

### Cheatsheet - [Link](https://kubernetes.io/docs/reference/kubectl/cheatsheet/)