import { createStore as _createStore, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import rootReducer from './modules/reducer';

const createStore = (initialState) => {
  const store = _createStore(
    rootReducer,
    initialState,
    applyMiddleware(thunk)
  );


  if (module.hot) {
    // Enable Webpack hot module replacement for reducers
    module.hot.accept('./modules/reducer', () => {
      const nextRootReducer = require('./modules/reducer').default;
      store.replaceReducer(nextRootReducer);
    });
  }

  return store;
};

export default createStore;
