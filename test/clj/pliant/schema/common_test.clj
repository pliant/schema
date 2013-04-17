(ns pliant.schema.common-test
  (:refer-clojure :exclude [transient])
  (:use clojure.test
        pliant.schema.common))

(deftest test-common-modifiers
  (is (true? (:required (required {:required false}))))
  (is (false? (:required (optional {:required true}))))
  (is (true? (:transient (transient {:transient false}))))
  (is (false? (:transient (persistable {:transient true}))))
  (is (strict? (strict {:fidelity :not-a-real-level})))
  (is (not (strict-in? (strict {:fidelity :not-a-real-level}))))
  (is (not (strict-out? (strict {:fidelity :not-a-real-level}))))
  (is (not (drunk? (strict {:fidelity :not-a-real-level}))))
  (is (not (strict? (strict-in {:fidelity :not-a-real-level}))))
  (is (strict-in? (strict-in {:fidelity :not-a-real-level})))
  (is (not (strict-out? (strict-in {:fidelity :not-a-real-level}))))
  (is (not (drunk? (strict-in {:fidelity :not-a-real-level}))))
  (is (not (strict? (strict-out {:fidelity :not-a-real-level}))))
  (is (not (strict-in? (strict-out {:fidelity :not-a-real-level}))))
  (is (strict-out? (strict-out {:fidelity :not-a-real-level})))
  (is (not (drunk? (strict-out {:fidelity :not-a-real-level}))))
  (is (not (strict? (drunk {:fidelity :not-a-real-level}))))
  (is (not (strict-in? (drunk {:fidelity :not-a-real-level}))))
  (is (not (strict-out? (drunk {:fidelity :not-a-real-level}))))
  (is (drunk? (drunk {:fidelity :not-a-real-level})))
  (is (strict? :strict))
  (is (strict-in? :strict-in))
  (is (strict-out? :strict-out))
  (is (drunk? :drunk))
  (is (not (strict? :not-a-real-level)))
  (is (not (strict-in? :not-a-real-level)))
  (is (not (strict-out? :not-a-real-level)))
  (is (not (drunk? :not-a-real-level))))