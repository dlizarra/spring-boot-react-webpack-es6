import React, { Component } from 'react';
import Header from './Header';
import ProjectList from './ProjectList';

export default class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <div className="container">
        <ProjectList /></div>
      </div>
    );
  }
}
