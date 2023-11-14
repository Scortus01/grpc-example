package co.edu.udem.isv.ejemplogrpc.server;

import co.edu.udem.isv.ejemplogrpc.HelloRequest;
import co.edu.udem.isv.ejemplogrpc.HelloResponse;
import co.edu.udem.isv.ejemplogrpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(
            HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


}