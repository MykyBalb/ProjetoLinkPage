import { useState } from "react"
import { AnimatePresence, motion } from "framer-motion"
import Login from '../../components/Login/Login';
import Register from '../../components/Register';


function LoginPage() {
  const [showLogin, setShowLogin] = useState(true)

  return (
    <div>
      <AnimatePresence mode="wait">
        {showLogin ? (
          <motion.div
            key="login"
            initial={{ opacity: 0, x: -50 }}
            animate={{ opacity: 1, x: 0 }}
            exit={{ opacity: 0, x: 50 }}
            transition={{ duration: 0.3 }}
          >
            <Login onToggle={() => setShowLogin(false)} />
          </motion.div>
        ) : (
          <motion.div
            key="register"
            initial={{ opacity: 0, x: 50 }}
            animate={{ opacity: 1, x: 0 }}
            exit={{ opacity: 0, x: -50 }}
            transition={{ duration: 0.3 }}
          >
            <Register onToggle={() => setShowLogin(true)} />
          </motion.div>
        )}
      </AnimatePresence>
    </div>
  )
}

export default LoginPage;