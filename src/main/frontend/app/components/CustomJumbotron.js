import React from 'react';
import { Jumbotron, Button } from 'react-bootstrap';

const CustomJumbotron = () => (
  <Jumbotron>
    <div className="container">
      <h1>Hello, world!</h1>
      <p>This is a template for a simple marketing or informational website.
        It includes a large callout called a jumbotron and three supporting pieces
        of content. Use it as a starting point to create something more unique.</p>
      <p><Button bsStyle="primary" bsSize="large">Learn more</Button></p>
    </div>
  </Jumbotron>
);

export default CustomJumbotron;
