import React from 'react';
import md5 from 'md5';

const Identicon = ({width, height, text}) => (
  <svg
    width={width}
    height={height}
    data-jdenticon-hash={md5(text)}
  />
);

export default Identicon;
