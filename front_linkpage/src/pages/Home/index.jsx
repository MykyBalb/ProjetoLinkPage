import "./styles.css";
import ImgBanner from "../../assets/banner.png";

function Home() {
  window.onload = () => {
    const btnStart = document.getElementById("btnStart");
    if (btnStart) {
      btnStart.addEventListener("click", () => {
        window.location.href = "/login";
      });
    }
  };

  return (
    <section className="home">
      <div>
        <h1>Todos os seus links em um só lugar</h1>
        <p>
          Crie sua página personalizada e compartilhe todos os seus links com
          facilidade.
        </p>
        <button id="btnStart">comece já</button>
      </div>
      <img src={ImgBanner} alt="imagem banner" />
    </section>
  );
}

export default Home;
