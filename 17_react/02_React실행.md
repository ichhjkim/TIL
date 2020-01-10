# 02_React실행

```
$ npx create-react-app my-app
cd my-app
npm start
```

## Bable이란?
컴파일러로 최신 Javascript코드를 구형 브라우저에도 실행되게 도와준다.

##  CDN을 통해 react를 사용할 때, crossorigin 속성이 필요한 이유
`<script crossorigin src="..."></script>`
또한 사용 중인 CDN이 Access-Control-Allow-Origin: * HTTP 헤더 설정을 사용하는지 확인하는 것이 좋습니다.