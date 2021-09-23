import React, {useState, useEffect } from 'react';
import ReactDOM from 'react-dom';

function Example() {
  // 새로운 state 변수를 선언하고, count라 부르겠습니다.
  const [count, setCount] = useState(0);
  const [test, setTest] = useState("test");

  useEffect(() => {
    // 브라우저 API를 이용하여 문서 타이틀을 업데이트합니다.
    document.title = `You clicked ${count} times`;
  });

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>
        Click me
      </button>

      <p>You clicked {test}</p>
      <button onClick={() => setTest("test2")}>
        Click me
      </button>
    </div>
  );
}

ReactDOM.render(<Example/>, document.getElementById("app"));