import './style.css'

function AnimatedInput({ id, label, type = 'text', ...outerProps }) {
  return (
    <div className="form-group">
      <input 
        type={type} 
        id={id} 
        className="form-input" 
        placeholder=" "
        {...outerProps}
      />
      <label htmlFor={id} className="form-label">
        {label}
      </label>
    </div>
  );
}

export default AnimatedInput;