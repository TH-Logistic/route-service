package com.thlogistic.route.core.usecases;

public interface BaseUseCase<Request, Response> {
    Response execute(Request request);
}
