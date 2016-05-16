import React, { Component } from 'react';
import { Grid, Row, Col } from 'react-bootstrap';
import ProjectListItem from './ProjectListItem';
import Identicon from './Identicon';
import md5 from 'md5';


class ProjectList extends Component {

  constructor(props) {
    super(props);
    this.props.fetchProjects();
  }

  render() {
    const { isFetching, list } = this.props.projects;
    const projectListItems = list.map(p => (
        <Col xs={12} md={4} key={p.id}>
          <ProjectListItem
            name={p.name}
            identicon={p.creator.username}
            creator={p.creator.username} />
        </Col>
      )
    );


    return (
      <div className="container">
        <Grid>
          <Row className="show-grid">
            {projectListItems}
          </Row>
        </Grid>
        <button onClick={this.props.fetchProjects}> fetch projects</button>
      </div>
    );
  }

  componentDidMount() {
    jdenticon();
  }

  componentDidUpdate() {
    jdenticon();
  }

}
;


export default ProjectList;
