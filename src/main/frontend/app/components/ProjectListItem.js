import React from 'react';
import Identicon from './Identicon';
import md5 from 'md5';

const ProjectListItem = ({ name, identicon, creator, description }) => (
  <div className="project-list-item">
    <div>
      <h4>{name}</h4>
    </div>
    <div>
      <Identicon width="34" height="34" text={md5(identicon)} />
      <span className="username">{` ${creator}`}</span>
    </div>
  </div>
);

export default ProjectListItem;
