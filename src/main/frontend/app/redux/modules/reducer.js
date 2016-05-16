import { combineReducers } from 'redux';
import projects from './projects';
import { routerReducer } from 'react-router-redux';

const rootReducer = combineReducers({
  projects,
  routing: routerReducer
});

export default rootReducer;
