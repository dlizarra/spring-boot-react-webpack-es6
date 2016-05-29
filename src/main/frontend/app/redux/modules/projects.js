import fetch from 'isomorphic-fetch';

export const REQUEST_PROJECTS = 'app/projects/REQUEST_PROJECTS';
export const RECEIVE_PROJECTS = 'app/projects/RECEIVE_PROJECTS';

const initialState = {
  isFetching: false,
  list: []
};

const reducer = (state = initialState, action = {}) => {
  switch (action.type) {
    case REQUEST_PROJECTS:
      return Object.assign({}, state, {
        isFetching: true,
        list: []
      });
    case RECEIVE_PROJECTS:
      return Object.assign({}, state, {
        isFetching: false,
        list: action.projects
      });
    default:
      return state;
  }
};

const requestProjects = () => (
  {
    type: REQUEST_PROJECTS
  }
);

const receiveProjects = (json) => (
  {
    type: RECEIVE_PROJECTS,
    projects: json
  }
);

export function fetchProjects() {
  return dispatch => {
    dispatch(requestProjects());
    return fetch('/projects')
      .then(response => response.json())
      .then(json => dispatch(receiveProjects(json)));
  };
}

export default reducer;
