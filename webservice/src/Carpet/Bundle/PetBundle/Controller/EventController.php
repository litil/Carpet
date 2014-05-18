<?php

namespace Carpet\Bundle\PetBundle\Controller;

use FOS\RestBundle\Controller\Annotations\Route;
use FOS\RestBundle\Routing\ClassResourceInterface;

class EventController implements ClassResourceInterface
{
    /**
     * @Route(requirements={"_format"="json"})
     */
    public function postAction() 
    {}
}
