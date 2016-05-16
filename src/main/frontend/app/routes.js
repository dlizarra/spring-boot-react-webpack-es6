import React from 'react';
import { Route, IndexRoute } from 'react-router';
import ProjectList from './containers/ProjectListContainer';
import App from './containers/App';

export default (
  <Route path="/" component={ App }>
    <Route path="projects" component={ProjectList} />
    <Route path="users" component={ProjectList} />
  </Route>
);
