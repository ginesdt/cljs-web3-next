(ns cljs-web3.api
  (:require [cljs-web3.macros :refer [defprotocol+]]))

(defprotocol+ Web3Api
  (-http-provider [this uri])
  (-websocket-provider [this uri])
  (-current-provider [this provider])
  (-set-provider [this provider])
  (-extend [this provider property methods])
  (-connection-url [this provider])
  (-is-listening? [this provider & [callback]])
  (-connected? [this provider])
  (-disconnect [this provider])
  (-on-connect [this provider & [callback]])
  (-on-disconnect [this provider & [callback]])
  (-on-error [this provider & [callback]])
  (-address? [this provider address])
  (-sha3 [this provider arg])
  (-solidity-sha3 [this provider [arg & [args]]])
  (-from-ascii [this provider arg])
  (-to-ascii [this provider arg])
  (-from-wei [this provider number & [unit]])
  (-to-wei [this provider number & [unit]])
  (-number-to-hex [this provider number])
  (-contract-at [this provider abi address])
  (-get-transaction-receipt [this provider tx-hash & [callback]])
  (-accounts [this provider])
  (-get-block-number [this provider & [callback]])
  (-get-block [this provider block-hash-or-number return-transactions? & [callback]])
  (-encode-abi [this contract-instance method args])
  (-contract-call [this contract-instance method args opts])
  (-contract-send [this contract-instance method args opts])
  (-subscribe-events [this contract-instance event opts & [callback]])
  (-subscribe-logs [this provider opts & [callback]])
  (-decode-log [this provider abi data topics])
  (-on [this event-emitter event callback])
  (-unsubscribe [this subscription & [callback]])
  (-clear-subscriptions [this provider])
  (-get-past-events [this contract-instance event opts & [callback]])
  (-increase-time [this provider seconds])
  (-mine-block [this provider]))
