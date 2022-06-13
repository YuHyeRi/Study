# [Spring Security] 인증/인가의 Exception

## *인증/인가 예외의 큰그림*

Spring Security에서 인증/인가에 대한 예외처리는 
***FilterSecurityFilter***와 ***ExceptionTranslationFilter***가 처리를 하게 된다. 
해당 필터는 ***AuthenticationException(인증예외)***과 ***AccessDeniedException(인가예외)***을 처리 한다. 
해당 예외들은 필터들 중 가장 마지막에 위치한 FilterSecurityFilter에서 발견을 하게 되는데 FilterSecurityFilter는 앞에 위치한 ExceptionTranslationFilter에서 try/catch 로 해당 예외들을 받기 위해 FilterSecurityFilter를 호출하여 사용하게 된다. FilterSecurityFilter에서 발생하는 인증/인가 예외는 FilterSecurityFilter를 호출한 ExceptionTranslationFilter에게로 인증/인가 예외를 throw하고 ExceptionTranslationFilter는 throw 받은 인증/인가 예외를 처리하는 일을 한다.

간단히 설명하자면, 
인증/인가의 exception은 *AccessDeniedException, AuthenticationException*. 
이를 *처리하는데 사용되는 필터는 FilterSecurityFilter, ExceptionTranslationFilter*인데 동작은 ExceptionTranslationFilter가 try/catch문을 통해 exception을 발견하는 FilterSecurityFilter를 호출하고 발생한 exception을 처리하게 된다.

👉 노션 : [https://velog.io/@seongwon97/Spring-Security-인증인가의-Exception](https://velog.io/@seongwon97/Spring-Security-%EC%9D%B8%EC%A6%9D%EC%9D%B8%EA%B0%80%EC%9D%98-Exception)
