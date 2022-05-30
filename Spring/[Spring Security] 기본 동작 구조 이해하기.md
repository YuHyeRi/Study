# [Spring Security] 기본 동작 구조 이해하기

### ***Spring Security의 동작 구조***

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/49319e97-663d-44b5-8e4f-001a2e3b7bee/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220530%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220530T022840Z&X-Amz-Expires=86400&X-Amz-Signature=e87314167d63e28a5530d28ff483e56833267425fc491580e7daeb3654d41512&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

- Spring Security의 의존성을 추가한 경우 위와 같이 `WebSecurityConfigurerAdapter`클래스가 실행 된다.
- `WebSecurityConfigurerAdapter`클래스는 Spring Security의 웹 보안 기능의 초기화 및 설정들을 담당하는 내용이 담겨있으며 내부적으로 `getHttp()`메서드가 실행될 때 `HTTPSecurity`클래스를 생성하게 된다.
- 이때의 HTTPSecurity는 인증/인가 API들의 설정을 제공한다.

```java
//WebSecurityConfigureAdapter.java파일의 일부

    protected final HttpSecurity getHttp() throws Exception {
		if (this.http != null) {
			return this.http;
		}    
		.....
        
        	if (!this.disableDefaults) {
			applyDefaultConfiguration(this.http); // defualt conf icuration적용		
            		.....   
                    
		}
		configure(this.http);
        // 이곳의 configure 메서드를 override하면 우리가 원하는 보안체계를 만들 수 있습니다.
		return this.http;
	}

	// 기본적으로 적용되는 filter들을 포함한 configuration 대한 메서드입니다.
	private void applyDefaultConfiguration(HttpSecurity http) throws Exception {
		http.csrf();
		http.addFilter(new WebAsyncManagerIntegrationFilter());
		http.exceptionHandling();
		http.headers();
		http.sessionManagement();
		http.securityContext();
		http.requestCache();
		http.anonymous();
		http.servletApi();
		http.apply(new DefaultLoginPageConfigurer<>());
		http.logout();
	}
```

- 우리가 인증/인가의 설정을 바꾸고자 한다면 `WebSecurityConfigurerAdapter`클래스를 상속한 SecurityConfig클래스를 생성하여 `configure(HttpSecurity http)`메서드를 override하며 설정해야 한다.

```java
//WebSecurityConfigureAdapter.java파일의 일부

	protected void configure(HttpSecurity http) throws Exception {
		this.logger.debug("Using default configure(HttpSecurity). "
				+ "If subclassed this will potentially override subclass configure(HttpSecurity).");
		http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
		http.formLogin();
		http.httpBasic();
	}
```

### ***사용자 정의 보안 기능 구현하기***

앞서 말했듯이 우리가 인증/인가의 설정을 바꾸고자 한다면 아래와 같이 `WebSecurityConfigurerAdapter`를 상속한 SecurityConfig클래스를 생성하여 `configure(HttpSecurity http)`메서드를 override하며 설정해야 한다.

예시코드는 다음과 같다.

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 인가 정책 설정
        http
                .authorizeRequests() // 요청에 대한 보안 검사 실행
                .anyRequest().authenticated(); // 어떠한 요청에도 인증을 받도록 설정
        
        // 인증 정책 설정
        http
                .formLogin(); // formLogin인증 방식을 사용하도록 설정
    }
}
```

### ***@EnableWebSecurity란?***

위의 SecurityConfig에 붙은 `@EnableWebSecurity`을 보면 WebSecurityConfiguration.class, SpringWebMvcImportSelector.class, OAuth2ImportSelector.class, HttpSecurityConfiguration.class들을 import해서 실행시켜주는 것을 알 수 있다. 해당 어노테이션을 붇어야 Security를 활성화 시킬 수 있다.

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({ WebSecurityConfiguration.class, SpringWebMvcImportSelector.class, OAuth2ImportSelector.class,
		HttpSecurityConfiguration.class })
@EnableGlobalAuthentication
@Configuration
public @interface EnableWebSecurity {

	/**
	 * Controls debugging support for Spring Security. Default is false.
	 * @return if true, enables debug support with Spring Security
	 */
	boolean debug() default false;

}
```

#### 👉 출처 : [https://velog.io/@seongwon97/security](https://velog.io/@seongwon97/security)
#### 👉 노션 : https://www.notion.so/Spring-Security-a839666059d54d9b855c0f9010921c0a
