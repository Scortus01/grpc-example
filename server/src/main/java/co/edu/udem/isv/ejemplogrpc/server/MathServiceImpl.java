package co.edu.udem.isv.ejemplogrpc.server;

import co.edu.udem.isv.maths.MathServiceGrpc;
import co.edu.udem.isv.maths.Maths;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class MathServiceImpl extends MathServiceGrpc.MathServiceImplBase {

    @Override
    public void sumar(Maths.Operands request, StreamObserver<Maths.Result> responseObserver) {
        double result = request.getOperand1() + request.getOperand2();
        Maths.Result response = Maths.Result.newBuilder().setValue(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void restar(Maths.Operands request, StreamObserver<Maths.Result> responseObserver) {
        double result = request.getOperand1() - request.getOperand2();
        Maths.Result response = Maths.Result.newBuilder().setValue(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void multiplicar(Maths.Operands request, StreamObserver<Maths.Result> responseObserver) {
        double result = request.getOperand1() * request.getOperand2();
        Maths.Result response = Maths.Result.newBuilder().setValue(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void dividir(Maths.Operands request, StreamObserver<Maths.Result> responseObserver) {
        if (request.getOperand2() == 0) {
            // Manejo de división por cero
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription("No se puede dividir por cero").asException());
            return;
        }
        double result = request.getOperand1() / request.getOperand2();
        Maths.Result response = Maths.Result.newBuilder().setValue(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
