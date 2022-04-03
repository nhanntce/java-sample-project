# Learn how to handle API Exception

## Step 1: Create a class that extend from *ResponseEntityExceptionHandler*
## Step 2: Add a *@ControllerAdvice* anontation for this class
## Step 3: Handle any exception following this funtion
```java
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String errorMessageDes = ex.getLocalizedMessage();
        //if the message that is parameter of Exception null
        if (errorMessageDes == null)
            errorMessageDes = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDes);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
```
