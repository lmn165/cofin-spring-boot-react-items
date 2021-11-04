import React from 'react';
import { Header, Footer } from 'features/common';
const Layout = (props) => {
    return (
      <div>
        <Header/>
        <main>
        {props.children}
        </main>
        <Footer />
      </div>
    )
  }
  
  export default Layout