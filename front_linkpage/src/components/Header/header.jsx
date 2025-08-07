import Logo from "../../assets/lynkael.svg";
import "./styles.css";

function header() {
  return (
    <header className="header">
      <div>
        <img src={Logo} alt="" />
        <h1>Lynkael</h1>
      </div>
      <nav className="navbar">
        <ul>
          <li>
            <a href="/">Home</a>
          </li>
          <li>
            <a href="/about">About</a>
          </li>
          <li>
            <a href="/contact">Contact</a>
          </li>
        </ul>
      </nav>
    </header>
  );
}

export default header;
