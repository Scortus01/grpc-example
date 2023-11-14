import co.edu.udem.isv.ejemplogrpc.server.HelloServiceImpl;
import co.edu.udem.isv.ejemplogrpc.server.MathServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new MathServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}