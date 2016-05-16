import '../style/main.css';
import React from 'react';
import { render } from 'react-dom';
import { Provider } from 'react-redux';
import { Router, hashHistory } from 'react-router';
import { syncHistoryWithStore } from 'react-router-redux';
import routes from './routes';
import createStore from './redux/create';

const initialState = window.__INITIAL_STATE__;
const store = createStore(initialState);
const rootElement = document.getElementById('root');

const history = syncHistoryWithStore(hashHistory, store);

render(
  <Provider store={ store }>
    <Router history={history} routes={routes} />
  </Provider>,
  rootElement
);

