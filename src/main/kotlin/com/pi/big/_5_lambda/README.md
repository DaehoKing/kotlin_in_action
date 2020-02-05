# Lambda

### 코틀린의 람다식 문법
```kotlin
    /*** 코틀린의 간결한 람다식 표현 ***/
    items.maxBy({item: Item -> item.price})
    items.maxBy(){item -> item.price}
    items.maxBy {item -> item.price}
    items.maxBy { it.price}
    
    items.toMap({ item -> item.name }, { item -> item.price })
    items.toMap({ item -> item.name }) { item -> item.price }
```
 - 파라미터가 여러개인 경우, 마지막 람다만 밖으로 쏙~ 빼는건 더 헷갈리는거 같음.  
 
### 코틀린 람다가 자바와 다른 것

### Member reference

### 컬렉션 API
- 매우 친숙한 내용이니 몇가지 내용만 짚고 스윽 넘어가보자

- 드모르간 법칙!  
```kotlin
    !listOf.any { it == 3} == listOf.all { it != 3 }
```  
- size vs count
```kotlin
    items.filter { it.price > 1000 }.size // => 메모리에 리스트를 할당 함.  
    items.count { it.price > 1000 } // => 조건을 만족하는 개수만 계산
```
- 확장함수도 member reference 가능!

### 자바 함수형 인터페이스에 람다 사용

### Scope Functions