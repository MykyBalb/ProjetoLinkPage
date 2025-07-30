import './styles.css'

function header() {
  return (
    <header className='header'>
      <h1>LinkPage<br />Empresa</h1>
      <nav className='navbar'>
        <ul>
          <li><a href="/">Home</a></li>
          <li><a href="/about">About</a></li>
          <li><a href="/contact">Contact</a></li>
        </ul>
      </nav>
    </header>
  );
}

export default header;