import React from 'react';
import { ListGroup, ListGroupItem } from 'react-bootstrap';
import ProjectListItem from './ProjectListItem';


const ProjectList = () => (
  <ListGroup className="list-unstyled" componentClass="ul">
    <ProjectListItem name="Project 1" />
  </ListGroup>
);

export default ProjectList;
