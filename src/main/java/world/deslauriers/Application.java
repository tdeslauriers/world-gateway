package world.deslauriers;

import io.dekorate.docker.annotation.DockerBuild;
import io.dekorate.kubernetes.annotation.*;
import io.micronaut.runtime.Micronaut;

@KubernetesApplication(
        name = "gateway",
        serviceType = ServiceType.ClusterIP,
        replicas = 3,
        imagePullPolicy = ImagePullPolicy.Always,
        labels = @Label(key = "app", value = "allowance"),
        ports = @Port(name = "http", hostPort = 8080, containerPort = 8085),
        envVars = {
                @Env(name = "AUTH_SERVICE_URL", configmap = "gateway-svc-config", value = "auth_url"),
                @Env(name = "GALLERY_SERVICE_URL", configmap = "gateway-svc-config", value = "gallery_url"),
                @Env(name = "ALLOWANCE_SERVICE_URL", configmap = "gateway-svc-config", value = "allowance_url"),
                @Env(name = "JWT_GENERATOR_SIGNATURE_SECRET", secret = "jwt", value = "signature-pw")
        }
)
@DockerBuild(group = "tdeslauriers", name = "gateway")
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
