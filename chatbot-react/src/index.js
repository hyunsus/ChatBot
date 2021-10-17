import React, {Suspense, lazy} from 'react';
import ReactDOM from 'react-dom';
import { Route, Switch, HashRouter as Router } from 'react-router-dom';
import './main/resources/css/style.css';

const App = () => {
  const Main = lazy(() => import( './main/jsx/main'));
  const Chat = lazy(() => import( './main/jsx/chat'));
  const VChat = lazy(() => import( './main/jsx/vchat'));
  
  return (
    <Router>
      <Suspense fallback={<div>Loading... </div>}>
        <Switch>
          <Route path="/" exact component={Main}/>
          <Route path="/chat" exact component={Chat}/>
          <Route path="/vchat" exact component={VChat}/>
        </Switch>
      </Suspense>
    </Router>
  );
}

ReactDOM.render(<App/>, document.getElementById("app"));