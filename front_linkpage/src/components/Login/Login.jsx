import Input from "../AnimatedInput";
import AuthLayout from "../AuthLayout";
import TitleForm from "../TitleForm";
import Button from "../AnimatedButton";
import "./stylesLogin.css";

function Login({ onToggle }) {
  return (
    <AuthLayout>
      <TitleForm title="Login" />
      <form>
        <Input label="Username" id="username" name="username" required />
        <Input
          label="Password"
          id="password"
          name="password"
          type="password"
          required
        />
        <div>
          {/* <a href=""> forgot password?</a> */}
        </div>
        <Button type="submit">Login</Button>
        <p>
          Don't have an account?{" "}
          <a href="#" onClick={onToggle}>
            Sign up
          </a>
        </p>
      </form>
    </AuthLayout>
  );
}

export default Login;
