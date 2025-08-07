import AuthLayout from "../AuthLayout";
import Input from "../AnimatedInput";
import TitleForm from "../TitleForm";
import Button from "../AnimatedButton";

function Register({ onToggle }) {
  return (
    <AuthLayout>
      <TitleForm title={"Register"} />
      <form>
        <Input label="Username" id="username" name="username" required />
        <Input label="Email" id="email" name="email" type="email" required />
        <Input
          label="Password"
          id="password"
          name="password"
          type="password"
          required
        />
        <Input
          label="Confirm Password"
          id="confirm-password"
          name="confirm-password"
          type="password"
          required
        />
        <Button type="submit">Register</Button>
        <p>Already have an account?{" "}<a href="#" onClick={onToggle}>Sign up</a></p>
      </form>
    </AuthLayout>
  );
}

export default Register;
