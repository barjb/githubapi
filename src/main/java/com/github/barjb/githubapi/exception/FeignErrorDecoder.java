package com.github.barjb.githubapi.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {
  private final ErrorDecoder defaultErrorDecoder = new Default();

  @Override
  public Exception decode(String methodKey, Response response) {
    if (response.status() >= 400 && response.status() <= 499) {
      return new BadRequestException("Bad request error from github service");
    }
    if (response.status() >= 500) {
      return new InternalServerErrorException(
          response.status() + " internal server error exception");
    }
    return defaultErrorDecoder.decode(methodKey, response);
  }
}
