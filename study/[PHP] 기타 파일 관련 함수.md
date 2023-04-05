# [PHP] 기타 파일 관련 함수

**파일 존재 여부 확인**

file_exists() 함수는 전달받은 파일이나 디렉터리가 존재하는지를 검사한다.
이 함수를 사용하면 파일을 열기 전에 먼저 해당 파일이 존재하는지를 확인할 수 있다.

```php
if(file_exists("list.txt"))
    echo "파일이 존재합니다.";
else
    echo "파일이 존재하지 않습니다.";
```

---

**파일 크기 확인**

filesize() 함수는 전달받은 파일의 크기를 바이트 값으로 반환한다.

```php
echo filesize("list.txt");
```

현재 대부분의 운영체제에서 PHP의 정수 타입으로 32비트 정수를 사용하고 있다.
따라서 파일의 크기가 2GB보다 크게 되면 filesize() 함수는 예상치 못한 결과를 반환할 수도 있다.

---

**파일 내부 탐색**

fopen() 함수의 결과로 반환된 파일 포인터를 이용하면 파일 내부를 직접 탐색할 수도 있다.
PHP에서는 파일 포인터의 위치를 변경하는 다음 함수를 제공한다.

1. ftell() : 전달받은 파일 포인터가 현재 가리키고 있는 위치를 반환한다.
2. rewind() : 전달받은 파일 포인터를 해당 파일의 맨 처음으로 이동시킨다.
3. fseek() : 전달받은 파일 포인터를 특정 위치로 이동시킨다.

```php
$fp = fopen("list.txt", 'r');    // list.txt 파일을 읽기 전용으로 열고 반환된 파일 포인터를 $fp에 저장함.

while(!feof($fp)){               // 파일의 끝까지
    $member = fgets($fp);        // 한 줄씩 $member 변수에 저장하고
    echo $member."<br/>";        // 출력함.
}

echo ftell($fp)."<br>";          // 현재 파일 포인터는 파일의 끝부분을 가리킴.
rewind($fp);                     // 파일 포인터를 파일의 시작 부분으로 이동시킴.
echo ftell($fp);
```

fseek() 함수는 첫 번째 인수로 파일 포인터를 전달받는다.
두 번째 인수로는 세 번째 인수를 기준으로 얼마만큼 파일 푄터를 옮겨야 하는지에 대한 오프셋을 
전달받는다.
세 번째 인수는 오프셋 기준을 나타내며 생략하면 SEEK_SET(파일의 처음)으르 기본값으로 설정한다.

오프셋 기준으로 전달할 수 있는 값은 다음과 같다.

1. *SEEK_SET : 파일의 처음을 기준으로 함. (기본 설정)*
2. *SEEK_CUR : 파일 포인터의 현재 위치를 기준으로 함.*
3. *SEEK_END : 파일의 끝을 기준으로 함.*

```php
$fp = fopen("list.txt", 'r');

fseek($fp, 0, SEEK_END);    // 파일 포인터를 파일의 끝으로 이동시킴.
echo ftell($fp)."<br>";

fseek($fp, 0);              // 파일 포인터를 파일의 맨 처음으로 이동시킴.
echo ftell($fp);
```

---

**파일 삭제**

unlink() 함수는 전달받은 주소에 위치한 파일을 삭제한다.
이 함수는 파일이 정상적으로 삭제됐을 때 true를 반환한다.
만약 파일을 지울 수 있는 권한이 없거나 파일이 존재하지 않은 경우, 
또는 파일이 정상적으로 삭제되지 못했을 때는 false를 반환한다.

```php
if(unlink("list.txt"))
    echo "파일 삭제 성공";
else
    echo "파일 삭제 실패";
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-0871304f39dd4eb1a86d0d7586c3ee3a?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_fileHandling_etc](http://www.tcpschool.com/php/php_fileHandling_etc)
