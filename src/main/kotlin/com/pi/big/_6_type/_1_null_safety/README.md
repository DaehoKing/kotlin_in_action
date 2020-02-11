**** Null Safety

코틀린에서 null 에러가 발생할 수 있는 경우
 - throw NullPointerException()
 - !! operator
 - 완전히 초기화 되지 않은 this의 상태를 사용
 
 코틀린에서는 **nullable references** / **non-null references** 타입을 구분한다.
 
 ```kotlin
val a:String = "pi.big"
a = null // (X) 컴파일 에러
```