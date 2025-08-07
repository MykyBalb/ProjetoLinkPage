import './AnimetedBtn.css'

function AnimatedButton({ onClick, children, type = 'button' }) {
    return (
        <button className='custom-btn' onClick={ onClick } type={ type }>{ children }</button>
    )
}

export default AnimatedButton;