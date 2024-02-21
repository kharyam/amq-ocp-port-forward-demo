# amq-ocp-port-forward-demo

Simple test of using port forwarding to connect to an amq broker on OCP via springboot

```bash
# Create brokers if they don't already exist
# oc apply -f amqbroker.yml

oc port-forward service/broker-acceptor-0-svc 61626:61626
```
